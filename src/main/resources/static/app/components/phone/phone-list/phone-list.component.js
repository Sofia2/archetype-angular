'use strict';

angular.
module('phone').component('phoneList', {
	   templateUrl:'app/components/phone/phone-list/phone-list.template.html',
	   controller: ['phoneFactory', function PhoneListController(phoneFactory) {
	      
		  this.phones = phoneFactory.query();

	   }]
});
