(function () {
    'use strict';
    
    console.log("ZooService has been read.");

    angular
        .module('app.zookeepr')
        .factory('zookeeprservice', zookeeprservice);
    
    zookeeprservice.$inject = ['$q', '$http'];
    /* @ngInject */
    function zookeeprservice($q, $http) {
    	
    	console.log("ZooService has been instantiated.");
    	
    	var service = {
            getEnclosures: getEnclosures,
            getAnimals: getAnimals,
            getFoods: getFoods
        };
    	
    	return service;
    	
    	function getAnimals() {
            var request = $http({
                method: "get",
                url: "api/animals/all",
                params: {
                    action: "get"
                }
            });
            return( request.then( handleSuccess, handleError ) );
        }
    	
    	function handleError( response ) {
            if (
                ! angular.isObject( response.data ) ||
                ! response.data.message
                ) {
                return( $q.reject( "An unknown error occurred." ) );
            }
            return( $q.reject( response.data.message ) );
        }
        function handleSuccess( response ) {
            return( response.data );
        }
    }
});