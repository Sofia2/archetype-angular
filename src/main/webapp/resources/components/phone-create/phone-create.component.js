'use strict';

angular.
module('phoneCreate').factory('phoneCreateFactory', ['$resource', function($resource) { 
	
	return {
		save: function(phone) {	    	
	    	return $resource('/phone/create').save(phone);			
	    }
	};
}]);


angular.
module('phoneCreate').component('phoneCreate', {
	   templateUrl:'resources/components/phone-create/phone-create.template.html',
	   controller: ['phoneCreateFactory', '$stateParams', '$scope', '$state',
	                function PhoneCreateController(phoneCreateFactory, $stateParams, $scope, $state) {
		   				
					    var self = this;
				        
		   			    // function to process the form
		   			    $scope.processForm = function() {
		   			        
							var result = phoneCreateFactory.save({id:$scope.id, name:$scope.name, 
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