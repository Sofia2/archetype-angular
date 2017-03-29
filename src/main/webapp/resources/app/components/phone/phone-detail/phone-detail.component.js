'use strict';


angular.
module('phone').component('phoneDetail', {
	   templateUrl:'resources/app/components/phone/phone-detail/phone-detail.template.html',
	   controller: ['phoneFactory', '$stateParams', '$scope', '$state', 
	                function PhoneDetailController(phoneFactory, $stateParams, $scope, $state) {
		   				
		   				this.phone = phoneFactory.show({id : $stateParams.phoneId});
		   				
		   				
		   				$scope.deletePhone = function (phoneId) {
		   					
		   					var result = phoneFactory.remove({ id: phoneId });
		   		            
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