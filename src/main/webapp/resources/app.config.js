angular.
  module('sofiaApp').
  config(['$locationProvider', '$routeProvider', '$httpProvider',
    function config($locationProvider, $routeProvider, $httpProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/phones', {
          template: '<phone-list></phone-list>'
        }).
        when('/phones/:phoneId', {
            template: '<phone-detail></phone-detail>'
        }).
        otherwise({redirectTo: '/phones'});
      
      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }
  ]);







