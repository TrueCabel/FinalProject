var app = angular.module('app', ['ngRoute']);
///////////////////////////////////////////////////////////////////////////////////
app.config(
		function($routeProvider){
			$routeProvider
				.when('/', {
					templateUrl: 'src/app/zookeepr/zookeepr.html',
					controller: 'ZooController'
				});
});
///////////////////////////////////////////////////////////////////////////////////
app.controller(
		"ZooController",
		function($q, zookeeprservice, $scope) {

	$scope.enclosures = [];
	$scope.enclosure = {};
	$scope.enclosureFields = [
	                          {
	                        	  key: 'enclosureName',
	                        	  type: 'textarea',
	                        	  templateOptions: {
	                        		  label: 'Enclosure Name',
	                        		  type: 'text',
	                        		  placeholder: 'Enter an Enclosure Name'
	                        	  }
	                          },
//	                          {
//	                        	  key: 'animal',
//	                        	  type: 'select',
//	                        	  templateOptions: {
//	                        		  label: 'Animal',
//	                        		  options: zookeeprservice.getAnimals()
//	                        	  }
//	                          },
	                          {
	                        	  key: 'numberOfAnimals',
	                        	  type: 'input',
	                        	  templateOptions: {
	                        		  label: 'Number of Animals',
	                        		  type: 'text',
	                        		  placeholder: '0'
	                        	  }
	                          }
	];
	$scope.animals = [];
	$scope.foods = [];
	
	getEnclosures();
	getAnimals();
	getFoods();
	
	function applyEnclosures(newEnclosures){
		$scope.enclosures = newEnclosures;
	}
	function getEnclosures() {
		zookeeprservice.getEnclosures()
		.then(
				function(result) {
			applyEnclosures(result);
		});
	}
	
	function applyAnimals(newAnimals){
		$scope.animals = newAnimals;
	}
	function getAnimals() {
		zookeeprservice.getAnimals()
		.then(
				function(result) {
			applyAnimals(result);
		});
	}
	
	function applyFoods(newFoods){
		$scope.foods = newFoods;
	}
	function getFoods() {
		zookeeprservice.getFoods()
		.then(
				function(result) {
			applyFoods(result);
		});
	}
});
///////////////////////////////////////////////////////////////////////////////////
app.service(
	"zookeeprservice",
	function($http, $q) {
	var service = {
        getEnclosures: getEnclosures,
        getAnimals: getAnimals,
        getFoods: getFoods
    };
	
	return service;
	
	function getEnclosures() {
        var request = $http({
            method: "get",
            url: "api/enclosure/all",
            params: {
                action: "get"
            }
        });
        return( request.then(handleSuccess, handleError));
    }
	
	function getAnimals() {
        var request = $http({
            method: "get",
            url: "api/animals/all",
            params: {
                action: "get"
            }
        });
        return(request.then(handleSuccess, handleError));
    }
	
	function getFoods() {
        var request = $http({
            method: "get",
            url: "api/food/all",
            params: {
                action: "get"
            }
        });
        return( request.then(handleSuccess, handleError));
    }
	
	function handleError(response) {
        if (
            ! angular.isObject( response.data ) ||
            ! response.data.message
            ) {
            return( $q.reject( "An unknown error occurred." ) );
        }
        return( $q.reject( response.data.message ) );
    }
    function handleSuccess(response) {
    	console.log(response.data);
        return( response.data );
    }
});