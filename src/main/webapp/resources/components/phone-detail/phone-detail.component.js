'use strict';

angular.
module('phoneDetail').factory('phoneDetailFactory', ['$resource', function($resource) {
    return $resource('/phone/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        remove: { method: 'DELETE', params: {id: '@id'} }
    });
	
}]);

angular.
module('phoneDetail').component('phoneDetail', {
	   templateUrl:'resources/components/phone-detail/phone-detail.template.html',
	   controller: ['phoneDetailFactory', '$stateParams', '$scope', '$state', 
	                function PhoneDetailController(phoneDetailFactory, $stateParams, $scope, $state) {
		   				
		   				this.phone = phoneDetailFactory.show({id : $stateParams.phoneId});
		   				
		   				
		   				$scope.deletePhone = function (phoneId) {
		   					
		   					var result = phoneDetailFactory.remove({ id: phoneId });
		   		            
		   					result.$promise.then(
						      //success
						      function( value ){
						    	  if (value.deleted){
						    		  $state.go("phones");
						    	  }
						      },
						      //error
						      function( error ){
						    	/*Do something with error*/
						    	console.log(error);
						      }
						    );
		   		        };
		   		        
		   		        
	   				}
	   ]
});