'use strict';

app
  .filter('htmlToTrusted', ['$sce', function($sce){
      return function(text) {
          return $sce.trustAsHtml(text);
      };
  }
]);
