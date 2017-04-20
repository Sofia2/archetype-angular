'use strict';


angular.
module('phone').component('phoneCreate', {
	   templateUrl:'app/components/phone/phone-create/phone-create.template.html',
	   controller: ['phoneFactory', '$stateParams', '$scope', '$state',
	                function PhoneCreateController(phoneFactory, $stateParams, $scope, $state) {
		   				
					    var self = this;
				        
		   			    // function to process the form
		   			    $scope.processForm = function() {
		   			        
							var result = phoneFactory.save({id:$scope.id, name:$scope.name, 
													 snippet : $scope.snippet,
													 imageUrl : $scope.imageUrl});
							
							result.$promise.then(
						      //success
						      function( value ){
						    	  if (value.created){
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