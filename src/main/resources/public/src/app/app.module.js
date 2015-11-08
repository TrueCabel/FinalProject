var app = angular.module('app', [ 'ngRoute', 'ui.bootstrap' ]);
// /////////////////////////////////////////////////////////////////////////////////
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'src/app/zookeepr/zookeepr.html',
		controller : 'ZooController'
	});
});
// /////////////////////////////////////////////////////////////////////////////////
app
	.controller(
	"ZooController",
	function($q, zookeeprservice, $scope, $uibModal) {

	$scope.enclosures = [];
	$scope.enclosure = {};

	$scope.animals = [];
	$scope.animal = {};

	$scope.foods = [];
	$scope.food = {};
	
	var conditionData = [ {
		"0" : "CRIMINAL"
	}, {
		"1" : "BAD"
	}, {
		"2" : "GOOD"
	}, {
		"3" : "GREAT"
	} ];
	$scope.conditionOptions = conditionData.reduce(function(memo, obj) {
		return angular.extend(memo, obj);
	}, {});

	var typeData = [ {
		"0" : "VEGITABLE"
	}, {
		"1" : "FRUIT"
	}, {
		"2" : "MEAT"
	}, {
		"3" : "NUT"
	} ];
	$scope.typeOptions = typeData.reduce(function(memo, obj) {
		return angular.extend(memo, obj);
	}, {});

	resetData();

	function resetData() {
		zookeeprservice.getEnclosures().then(function(result) {
			$scope.enclosures = result;
		});

		zookeeprservice.getAnimals().then(function(result) {
			$scope.animals = result;
		});

		zookeeprservice.getFoods().then(function(result) {
			$scope.foods = result;
		});
	}

	$scope.clearEnclosure = function() {
		$scope.enclosure = {};
	}
	$scope.setEnclosure = function(enclosure) {
		console.log(enclosure);
		$scope.enclosure.enclosureID = enclosure.enclosureID;
		$scope.enclosure.enclosureName = enclosure.enclosureName;
		$scope.enclosure.animal = enclosure.animal;
		$scope.enclosure.numberOfAnimals = enclosure.numberofAnimals;
		$scope.enclosure.enclosureCondition = enclosure.enclosureCondition;
	}
	$scope.submitEnclosure = function() {
		zookeeprservice.submitEnclosure($scope.enclosure).then(function() {
			resetData();
		});
	}
	$scope.deleteEnclosure = function(id) {
		console.log("In Controller: " + $scope.enclosure.enclosureID);
		zookeeprservice.deleteEnclosure($scope.enclosure.enclosureID).then(function() {
			resetData();
		});
	}

	$scope.clearAnimal = function() {
		$scope.animal = {};
	}
	$scope.setAnimal = function(animal) {
		$scope.animal = animal;
	}
	$scope.submitAnimal = function() {
		zookeeprservice.submitAnimal($scope.animal).then(function() {
			resetData();
		});
	}

	$scope.clearFood = function() {
		$scope.food = {};
	}
	$scope.setFood = function(food) {
		$scope.food = food;
	}
	$scope.submitFood = function() {
		zookeeprservice.submitFood($scope.food).then(function() {
			resetData();
		});
	}
});
// /////////////////////////////////////////////////////////////////////////////////
app.service("zookeeprservice", function($http, $q) {
	var service = {
		getEnclosures : getEnclosures,
		submitEnclosure : submitEnclosure,
		deleteEnclosure: deleteEnclosure,
		getAnimals : getAnimals,
		submitAnimal : submitAnimal,
		getFoods : getFoods,
		submitFood : submitFood
	};

	return service;

	function getEnclosures() {
		return $http.get('api/enclosure/all').then(handleSuccess, handleError);
	}
	function submitEnclosure(enclosure) {
		return $http.post('api/enclosure', enclosure).then(handleSuccess,
				handleError)
	}
	function deleteEnclosure(id) {
		console.log("In Service: " + id);
		return $http.delete('api/enclosure', id).then(handleSuccess,
				handleError)
	}

	function getAnimals() {
		return $http.get('api/animals/all').then(handleSuccess, handleError);
	}
	function submitAnimal(animal) {
		return $http.post('api/animals', animal).then(handleSuccess,
				handleError)
	}

	function getFoods() {
		return $http.get('api/food/all').then(handleSuccess, handleError);
	}
	function submitFood(food) {
		return $http.post('api/food', food).then(handleSuccess, handleError)
	}

	function handleError(response) {
		if (!angular.isObject(response.data) || !response.data.message) {
			return ($q.reject("An unknown error occurred."));
		}
		return ($q.reject(response.data.message));
	}
	function handleSuccess(response) {
		return (response.data);
	}
});