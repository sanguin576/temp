'use strict';
/**
 * Clip-Two Main Controller
 */
app.controller('AppCtrl', ['$rootScope', '$scope', '$state', '$translate', '$localStorage', '$window', '$location', '$document', '$timeout',
	'cfpLoadingBar', 'sessionService', 'authorizationService', 'logoutService',
	function ($rootScope, $scope, $state, $translate, $localStorage, $window, $location, $document, $timeout, cfpLoadingBar, sessionService, authorizationService, logoutService) {

		/* Changes for Incident 8235584 starts here
		 * Description : Restricting backspace working as backbutton for (Not of Input/textarea/select type values, checkboxes, radio buttons, read only fields) in IE
		 * Solution Implemented : preventing the default behavior of IE when the backspace was clicked for the above mentioned scenarios
		 *
		 */
		$document.on('keydown keypress', function (e) {
			var readOnly = event.target.attributes.getNamedItem('readOnly');

			if (e.which === 8 && (e.target.nodeName !== "INPUT" && e.target.nodeName !== "TEXTAREA" && e.target.nodeName !== "SELECT" ||
				e.target.type == "checkbox" || e.target.type == "radio" || (readOnly != null && readOnly.value == 'true'))) {
				e.preventDefault();
			}
		});
		/* Changes for Incident 8235584  ends here*/

		// Loading bar transition
		// -----------------------------------
		var $win = $($window);
		$rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
			//start loading bar on stateChangeStart
			cfpLoadingBar.start();

		});
		$rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {

			//stop loading bar on stateChangeSuccess
			event.targetScope.$watch("$viewContentLoaded", function () {

				cfpLoadingBar.complete();
			});

			// scroll top the page on change state

			$document.scrollTo(0, 0);

			if (angular.element('.email-reader').length) {
				angular.element('.email-reader').animate({
					scrollTop: 0
				}, 0);
			}

			// Save the route title
			$rootScope.currTitle = $state.current.title;
		});

		// State not found
		$rootScope.$on('$stateNotFound', function (event, unfoundState, fromState, fromParams) {

			// "lazy.state"

			// {a:1, b:2}
		});

		$rootScope.pageTitle = function () {
			return $rootScope.app.name + ' - ' + ($rootScope.currTitle || $rootScope.app.description);
		};

		// save settings to local storage
		if (angular.isDefined($localStorage.layout)) {
			$scope.app.layout = $localStorage.layout;

		} else {
			$localStorage.layout = $scope.app.layout;
		}
		$scope.$watch('app.layout', function () {
			// save to local storage
			$localStorage.layout = $scope.app.layout;
		}, true);

		//global function to scroll page up
		$scope.toTheTop = function () {

			$document.scrollTopAnimated(0, 600);

		};
		
		function getCookie(name) {
		    var dc = document.cookie;
		    var prefix = name + "=";
		    var begin = dc.indexOf("; " + prefix);
		    if (begin == -1) {
		        begin = dc.indexOf(prefix);
		        if (begin != 0) return null;
		    }
		    else
		    {
		        begin += 2;
		        var end = document.cookie.indexOf(";", begin);
		        if (end == -1) {
		        end = dc.length;
		        }
		    }
		    // because unescape has been deprecated, replaced with decodeURI
		    //return unescape(dc.substring(begin + prefix.length, end));
		    return decodeURI(dc.substring(begin + prefix.length, end));
		} 

		$rootScope.validSession = function () {
			var myCookie = getCookie("token");
			var myloginCookie = getCookie("logintoken");
			if(myloginCookie === null && window.location.href.indexOf("token") === -1){
				if ($rootScope.user.userId === "") {
					//alert("redirecting to microsoft user ID NULL");
					$rootScope.user.name = '';
					$rootScope.user.picture = 'resources/images/defaultuser.png';
					var loginurl = "https://login.microsoftonline.com/56c62bbe-8598-4b85-9e51-1ca753fa50f2/oauth2/v2.0/authorize?client_id=198145d1-ad10-4733-a854-7daf3291dbc9&response_type=token&redirect_uri=http://localhost:8080&scope=user.read";
					console.log("redirect to MS Login - undefined error");
					window.location.href = loginurl;
				}
				
			}
			else if(myloginCookie === null){
				if(window.location.href.indexOf("token") !== -1){
					var value = window.location.href.split('access_token=')[1].split('&token_type')[0];
					var tkn = "token" + "=" + value;
					console.log(tkn);
					document.cookie = tkn;
					var logintkn = "logintoken" + "= true";
					console.log(logintkn);
					document.cookie = logintkn;
					parent.location.hash = '';
					$rootScope.user.userId = "";
					try {
						sessionService.getSessionAzure().success(function (data) {
							console.log(data);
							try {
								console.log("calling graph API");
								var resultName = data.displayName.split(" ")[0];

								var resultLastName = data.displayName.split(" ")[1];

								var resultUserID = data.onPremisesSamAccountName;
								var resultHumadUserID = data.onPremisesSamAccountName;

								var akaName = "aka" + resultHumadUserID;
							}
							catch (err) {
								var loginurl = "https://login.microsoftonline.com/56c62bbe-8598-4b85-9e51-1ca753fa50f2/oauth2/v2.0/authorize?client_id=198145d1-ad10-4733-a854-7daf3291dbc9&response_type=token&redirect_uri=http://localhost:8080&scope=user.read";
								console.log("redirect to MS Login-Error in Graph API call");
								//window.location.href = loginurl;
							}
							console.log(data);
							console.log(resultName);

							//No need to reload the image everytime we check the user session, only if the user changes
							if ($rootScope.user.humadUserID === undefined || $rootScope.user.humadUserID !== resultUserID) {

								$rootScope.user.userId = resultUserID;
								$rootScope.user.humadUserID = resultHumadUserID;
								$rootScope.user.name = resultName + ' ' + resultLastName;
								$rootScope.user.akaName = akaName;

								var imageURL = 'http://mysite.dummy.com/User%20Photos/Profile%20Pictures/humad_' + resultHumadUserID + '_LThumb.jpg';
								var userImg = document.createElement('img');
								userImg.onload = function () {
									$rootScope.user.picture = imageURL;
								}
								userImg.onerror = function () {
									$rootScope.user.picture = 'resources/images/defaultuser.png';
									// image did not load
								}
								userImg.src = imageURL;

								authorizationService.authorization(resultHumadUserID)
									.success(function (data) {
										$rootScope.user.authorization = data;

										console.log(data);

										for (var i = 0; i < data.length; i++) {
											if (data[i].genKey === 8327) {
												$rootScope.user.showLinks.dummyApp = true;
												$scope.link = data[i].initialURL;
											} else if (data[i].genKey === 8392 || data[i].genKey === 8379) {
												$rootScope.user.showLinks.reports = true;
											} else if (data[i].genKey === 8429 || data[i].genKey === 8430 || data[i].genKey === 8431) {
												$rootScope.user.showLinks.pbp = true;
											}

											// Add Scheduler Permision for Super Admin
											if (8391 == data[i].genKey) {
												$rootScope.user.showLinks.scheduler = true;
											}
										}
										

									}).error(function (data, status) {
										//alert('Error: ' + status);
										console.log("Error in User Details");
									});
								
							}
						}).error(function (data, status) {
							//alert('Error');
							//alert(data);
							//alert(status);
							console.log(data);
							$rootScope.user.name = '';
							$rootScope.user.picture = 'resources/images/defaultuser.png';
							var loginurl = "https://login.microsoftonline.com/56c62bbe-8598-4b85-9e51-1ca753fa50f2/oauth2/v2.0/authorize?client_id=198145d1-ad10-4733-a854-7daf3291dbc9&response_type=token&redirect_uri=https://dev-dummyAppportal.dummy.com/&scope=user.read";
							console.log("redirect to MS Login-error in Azurefn");
							window.location.href = loginurl;
						});
					}
					catch (err) {
						console.log(err);
						$rootScope.user.name = '';
						$rootScope.user.picture = 'resources/images/defaultuser.png';
						var loginurl = "https://login.microsoftonline.com/56c62bbe-8598-4b85-9e51-1ca753fa50f2/oauth2/v2.0/authorize?client_id=198145d1-ad10-4733-a854-7daf3291dbc9&response_type=token&redirect_uri=https://dev-dummyAppportal.dummy.com&scope=user.read";
						console.log("redirect to MS Login - undefined error");
						window.location.href = loginurl;
					}

				
					
				}
			}

				

			



			/*sessionService.getSessionEx(sessionID)
				.success(function(data)
				{
					var indexBegin = data.lastIndexOf('<NoRecordFound>');
					var indexEnd = data.lastIndexOf('</NoRecordFound>');
					var sessionRecord = data.substring(indexBegin + 15, indexEnd);
	
					indexBegin = data.lastIndexOf('<ResponseStatus>');
					indexEnd = data.lastIndexOf('</ResponseStatus>');
					var sessionStatus = data.substring(indexBegin + 16, indexEnd);
	
					if(sessionRecord === 'False' && sessionStatus === 'Success')
					{
						indexBegin = data.lastIndexOf('<FirstName>');
						indexEnd = data.lastIndexOf('</FirstName>');
						var resultName = data.substring(indexBegin + 11, indexEnd);
	
						indexBegin = data.lastIndexOf('<LastName>');
						indexEnd = data.lastIndexOf('</LastName>');
						var resultLastName = data.substring(indexBegin + 10, indexEnd);
	
						indexBegin = data.lastIndexOf('<UserID>');
						indexEnd = data.lastIndexOf('</UserID>');
						var resultUserID = data.substring(indexBegin + 8, indexEnd);
	
						indexBegin = data.lastIndexOf('<EntityUserAttribute Identifier="HR_TSOID" value="');
						indexEnd = data.lastIndexOf('" /></EntityUserAttributes>');
						var resultHumadUserID;
						if (indexBegin != -1)
						{
							resultHumadUserID = data.substring(indexBegin + 50, indexEnd);
						}
						else
						{
							resultHumadUserID = resultUserID;
						}
	
						indexBegin = data.lastIndexOf('<AkaName>');
						indexEnd = data.lastIndexOf('</AkaName>');
						var akaName = data.substring(indexBegin + 9, indexEnd);
	
						//No need to reload the image everytime we check the user session, only if the user changes
						if ($rootScope.user.humadUserID === undefined || $rootScope.user.humadUserID !== resultUserID)
						{
							var imageURL = 'http://mysite.dummy.com/User%20Photos/Profile%20Pictures/humad_'+resultHumadUserID+'_LThumb.jpg';
							var userImg = document.createElement('img');
							userImg.onload = function() {
								$rootScope.user.picture = imageURL;
							}
							userImg.onerror = function() {
								$rootScope.user.picture = 'resources/images/defaultuser.png';
								// image did not load
							}
							userImg.src = imageURL;
	
							authorizationService.authorization(sessionID)
							.success(function(data) {
								$rootScope.user.authorization = data;
							}).error(function(data, status) {
								alert('Error: ' + status);
							});
						}
	
						$rootScope.user.userId = resultUserID;
						$rootScope.user.humadUserID = resultHumadUserID;
						$rootScope.user.name = resultName + ' ' + resultLastName;
						$rootScope.user.akaName = akaName;
	
						sessionService.getBusinessFcn($rootScope.user.akaName, sessionID)
						.success(function(data)
						{
							//	Portal
							//		8379	dummyApp Portal
							//	dummyApp
							//		8327	dummyApp
							//	reports
							//		8392	Medicare Reports User
							//	PBP
							//		8429	Feed_Admin
							//		8430	Feed_DPM_Admin
							//		8431	Feed_Standard_User
	
	
							for(var i = 0; i < data.length; i++){
								if(data[i].genKey === 8327){
									$rootScope.user.showLinks.dummyApp = true;
									$scope.link = data[i].initialURL;
								} else if(data[i].genKey === 8392 || data[i].genKey === 8379){
									$rootScope.user.showLinks.reports = true;
								} else if(data[i].genKey === 8429 || data[i].genKey === 8430 || data[i].genKey === 8431){
									$rootScope.user.showLinks.pbp = true;
								}
	
								// Add Scheduler Permision for Super Admin
								if( 8391 == data[i].genKey ){
									$rootScope.user.showLinks.scheduler = true;
								}
							}
	
						}).error(function(data, status) {
	
						});
					}
					else //if session is not Valid --> goes to Redirect page
					{
						$rootScope.user.name = '';
						$rootScope.user.picture = 'resources/images/defaultuser.png';
						$location.url('/app/Redirect');
					}
				}).error(function(data, status) {
					$rootScope.user.name = '';
					$rootScope.user.picture = 'resources/images/defaultuser.png';
					$location.url('/app/Redirect');
				});
	
	*/
		};

		$rootScope.validSession();


		$rootScope.dummyAppLink = function (link) {
			if (link != '') {
				window.location.href = link;
			}
		};

		$rootScope.logOut = function () {
			var url = '';

			switch ($location.host()) {
				case 'qa-dummyAppportal.dummy.com':
					url = 'https://qa-hi.dummy.com';
					break;
				case 'dummyAppportal.dummy.com':
					url = 'https://hi.dummy.com';
					break;
				default:
					url = 'http://test-hi.dummy.com';
					break;

			}

			logoutService.logout()
				.success(function (data) {
					window.location.href = url;
				}).error(function (data, status) {
					alert('Error: ' + status);
				});
		};

		// angular translate
		// ----------------------

		$scope.language = {
			// Handles language dropdown
			listIsOpen: false,
			// list of available languages
			available: {
				'en': 'English'
			},
			// display always the current ui language
			init: function () {
				var proposedLanguage = $translate.proposedLanguage() || $translate.use();
				var preferredLanguage = $translate.preferredLanguage();
				// we know we have set a preferred one in app.config
				$scope.language.selected = $scope.language.available[(proposedLanguage || preferredLanguage)];
			},
			set: function (localeId, ev) {
				$translate.use(localeId);
				$scope.language.selected = $scope.language.available[localeId];
				$scope.language.listIsOpen = !$scope.language.listIsOpen;
			}
		};

		$scope.language.init();

		// Function that find the exact height and width of the viewport in a cross-browser way
		var viewport = function () {
			var e = window, a = 'inner';
			if (!('innerWidth' in window)) {
				a = 'client';
				e = document.documentElement || document.body;
			}
			return {
				width: e[a + 'Width'],
				height: e[a + 'Height']
			};
		};
		// function that adds information in a scope of the height and width of the page
		$scope.getWindowDimensions = function () {
			return {
				'h': viewport().height,
				'w': viewport().width
			};
		};

		// Session handlers

		$rootScope.refreshSession = function () {
			if (angular.isDefined($rootScope.sessionTimeout)) {
				$timeout.cancel($rootScope.sessionTimeout);
			}

			if ($rootScope.app.layout.baseRefreshSwitch) {
				$rootScope.sessionTimeout = $timeout(function () {
					$location.url('/app/Redirect');
				}, 20 * 60 * 1000);
			}
		};

		$rootScope.refreshSession();

		$scope.$on('$destroy', function () {
			// Make sure that the interval is destroyed too
			$timeout.cancel($rootScope.sessionTimeout);
		});


		//REDIRECT TO dummyApp
		$scope.goToPBP = function () {
			window.location.href = '/PBP/#/app/pbp';
		};

		// Detect when window is resized and set some variables
		$scope.$watch($scope.getWindowDimensions, function (newValue, oldValue) {
			$scope.windowHeight = newValue.h;
			$scope.windowWidth = newValue.w;
			if (newValue.w >= 992) {
				$scope.isLargeDevice = true;
			} else {
				$scope.isLargeDevice = false;
			}
			if (newValue.w < 992) {
				$scope.isSmallDevice = true;
			} else {
				$scope.isSmallDevice = false;
			}
			if (newValue.w <= 768) {
				$scope.isMobileDevice = true;
			} else {
				$scope.isMobileDevice = false;
			}
		}, true);
		// Apply on resize
		$win.on('resize', function () {
			$scope.$apply();
		});
	}]);

app.factory("sessionService", function ($http) {
	return {
		// getSessionEx: function(sessionID) {
		// 	return $http.get("rest/session/" + sessionID);
		// },
		getSessionAzure: function () {
			return $http.get("rest/session/azure");
		}
		// getBusinessFcn: function(akaname,sessionID) {
		// 	return $http.get("rest/acl/bf/" +akaname+ "/"+sessionID);
		// }
	}
});

app.factory("authorizationService", function ($http) {
	return {
		authorization: function (userId) {
			return $http.get("/rest/security/authorization/" + userId);
		}
	}
});

app.factory("logoutService", function ($http) {
	return {
		logout: function () {
			return $http.get("rest/logout");
		}
	}
});

