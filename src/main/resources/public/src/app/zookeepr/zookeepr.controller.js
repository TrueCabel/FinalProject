(function() {
	'use strict';
	
	console.log("ZooController has been read.");

	angular
		.module('app.zookeepr')
		.controller('ZooController', ZooController);

	ZooController.$inject = [ '$q', 'zookeeprservice', '$scope' ];
	/* @ngInject */
	function ZooController($q, zookeeprservice, $scope) {
		
		console.log("ZooController has been instantiated.");
		
		var zm = this;
		$scope.message = "This is a triumph (hopefully).";

		$scope.enclosures = [];

		$scope.animals = [];
		$scope.animal = {};
		var animalPromise = zookeeprservice.getAnimals();
		animalPromise.then(function(result) {
			$scope.animals = result;
			console.log(result);
		});

		$scope.foods = [];

		function getEnclosures() {

		}

		function getFood() {

		}
	}
});