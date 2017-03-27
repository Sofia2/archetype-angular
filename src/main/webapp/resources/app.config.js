angular.
  module('sofiaApp').
  config(['$locationProvider', '$stateProvider', '$urlRouterProvider', '$httpProvider',
    function config($locationProvider, $stateProvider, $urlRouterProvider, $httpProvider) {
      $locationProvider.hashPrefix('!');
      /*
      $routeProvider.
        when('/phones', {
          template: '<phone-list></phone-list>'
        }).
        when('/phones/:phoneId', {
            template: '<phone-detail></phone-detail>'
        }).
        otherwise({redirectTo: '/phones'});
      */
      
      $urlRouterProvider.otherwise('/phones');

      $stateProvider
      .state('phones', {
          url:'/phones',
          template: '<phone-list></phone-list>'
      })
      .state('phone', {
          url:'/phone/:phoneId',
          template: '<phone-detail></phone-detail>'
      });
      
      
      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }
  ]);







