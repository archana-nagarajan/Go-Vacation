'use strict';

angular.
  module('govacationApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          template: '<homepage></homepage>'
        }).
        when('/places/locality/:locality/category/:category', {
          template: '<places-list></places-list>'
        }).
        otherwise('/');

        
    }
  ]);
