'use strict';

angular.
module('phoneDetail').factory('phoneDetailFactory', ['$resource', function($resource) { 
	
	return {
	    get: function(phoneId) {
	      return $resource('/phone/'+ phoneId).get();
	    }
	};
}]);

angular.
module('phoneDetail').component('phoneDetail', {
	   templateUrl:'resources/components/phone-detail/phone-detail.template.html',
	   controller: ['phoneDetailFactory', '$stateParams', 
	                function PhoneDetailController(phoneDetailFactory, $stateParams) {
		   				this.phone = phoneDetailFactory.get($stateParams.phoneId);
	   				}
	   ]
});