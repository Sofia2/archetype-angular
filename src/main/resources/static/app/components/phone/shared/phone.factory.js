'use strict';

angular.
module('phone').factory('phoneFactory', ['$resource', function($resource) {
    return $resource('/phone/:id', {}, {
        show: { method: 'GET' },
        save:   {method:'POST', url : '/phone/create'},
        query:  {method:'GET', isArray:true, url: '/phone/list'},
        update: { method: 'PUT', params: {id: '@id'} },
        remove: { method: 'DELETE', params: {id: '@id'} }
    });
	
}]);
