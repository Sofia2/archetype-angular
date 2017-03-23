'use strict';

angular.
module('phoneList').factory('phoneFactory', ['$resource', function($resource) { 
	return $resource('/phone/list');
}]);

angular.
module('phoneList').component('phoneList', {
	   templateUrl:'resources/components/phone-list/phone-list.template.html',
	   controller: ['phoneFactory', function PhoneListController(phoneFactory) {
	      
		  this.phones = phoneFactory.query();

	   }]
});
