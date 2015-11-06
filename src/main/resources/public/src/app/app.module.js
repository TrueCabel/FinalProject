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
	
	$scope.animals = [];
	$scope.animal = {};
	
	$scope.foods = [];
	$scope.food = {};
	
	resetData();

	function resetData() {
		zookeeprservice.getEnclosures()
		.then(
				function(result) {
					$scope.enclosures = result;
				});
		
		zookeeprservice.getAnimals()
		.then(
				function(result) {
					$scope.animals = result;
		});
		
		zookeeprservice.getFoods()
		.then(
				function(result) {
					$scope.foods = result;
		});
	}
	
	$scope.clearEnclosure = function() {
		$scope.enclosure = {};
	}
	
	$scope.submitEnclosure = function() {
		console.log($scope.enclosure.enclosure_condition);
		zookeeprservice.submitEnclosure($scope.enclosure)
		.then(
				function() {
					resetData();
		});
	}
});
///////////////////////////////////////////////////////////////////////////////////
app.service(
	"zookeeprservice",
	function($http, $q) {
	var service = {
        getEnclosures: getEnclosures,
        submitEnclosure: submitEnclosure,
        getAnimals: getAnimals,
        getFoods: getFoods
    };
	
	return service;
	
	function getEnclosures() {
		return $http.get('api/enclosure/all')
        .then(handleSuccess, handleError);
    }
	function submitEnclosure(enclosure) {
		return $http.post('api/enclosure', enclosure)
        .then(handleSuccess, handleError)
	}
	
	function getAnimals() {
		return $http.get('api/animals/all')
        .then(handleSuccess, handleError);
    }
	
	function getFoods() {
		return $http.get('api/food/all')
        .then(handleSuccess, handleError);
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