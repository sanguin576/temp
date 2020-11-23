var app = angular.module('dummyAppApp', ['clip-two', 'rzModule']);
app.run(['$rootScope', '$state', '$stateParams', '$location', 'appInfoService',
function ($rootScope, $state, $stateParams, $location, appInfoService) {

    // Attach Fastclick for eliminating the 300ms delay between a physical tap and the firing of a click event on mobile browsers
    FastClick.attach(document.body);

    // Set some reference to access them from any scope
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;

    // GLOBAL APP SCOPE
    // set below basic information
    $rootScope.app = {
        name: 'dummyApp Portal', // name of your project
        author: 'dummy.com', // author's name or company name
        description: 'dummyApp Portal', // brief description
        version: '', // current version
        buildDate: '',
        hostname: '',
        year: ((new Date()).getFullYear()), // automatic current year (for copyright information)
        isMobile: (function () {// true if the browser is a mobile device
            var check = false;
            if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
                check = true;
            }
            return check;
        })(),
        layout: {
            isNavbarFixed: true, //true if you want to initialize the template with fixed header
            isSidebarFixed: true, // true if you want to initialize the template with fixed sidebar
            isSidebarClosed: false, // true if you want to initialize the template with closed sidebar
            isFooterFixed: true, // true if you want to initialize the template with fixed footer
            theme: 'theme-5', // indicate the theme chosen for your project
            logo: 'resources/images/logo.png' // relative path of the project logo
        }
    };

    $rootScope.user = {
        name: '',
        akaName: '',
        job: '',
        picture: 'resources/images/defaultuser.png',
        userId: '',
        humadUserID: '',
        authorization: undefined,
        showLinks: { dummyApp: false, reports: false, pbp: false, scheduler:false }
    };

    appInfoService.appinfo()
    	.success(function(data)
		{
    		if (data.length === 3)
			{
    			$rootScope.app.version = data[0];
    			$rootScope.app.buildDate = data[1];
    			$rootScope.app.hostname = data[2];
			}
    	}).error(function(data, status) {
    		console.log("Error: " + status);
        });

}]);
// translate config
app.config(['$translateProvider',
function ($translateProvider) {

    // prefix and suffix information  is required to specify a pattern
    // You can simply use the static-files loader with this pattern:
    $translateProvider.useStaticFilesLoader({
        prefix: 'resources/i18n/',
        suffix: '.json'
    });

    // Since you've now registered more then one translation table, angular-translate has to know which one to use.
    // This is where preferredLanguage(langKey) comes in.
    $translateProvider.preferredLanguage('en');

    // Store the language in the local storage
    $translateProvider.useLocalStorage();

}]);
app.config(['cfpLoadingBarProvider',
function (cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeBar = true;
    cfpLoadingBarProvider.includeSpinner = false;

}]);

app.config(function(tagsInputConfigProvider) {
	  tagsInputConfigProvider.setTextAutosizeThreshold(100);
});

app.factory("appInfoService", function($http)
{
    return {
    	appinfo: function() {
    		return $http.get("/rest/util/appinfo");
    	}
    }
});
