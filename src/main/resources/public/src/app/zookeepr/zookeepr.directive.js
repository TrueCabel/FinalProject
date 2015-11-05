(function () {
    'use strict';
    
    console.log("ZooDirective has been read.");

    angular
    	.module('app.zookeepr')
    	.directive('ZooDirective', ZooDirective);

    /**
     * This function creates the directive.
     */
    /* @ngInject */
    function ZooDirective() {
    	
    	console.log("ZooDirective has been instantiated.");
    	
        var directive = {
            scope: {
                checkReport: '='
            },
            restrict: 'E',
            templateUrl: 'app/zookeepr/zookeepr.html',
            controller: ['zookeeprservice', '$scope', 'ZooController'],
            controllerAs: 'zm',
        };
        return directive;
    }
});