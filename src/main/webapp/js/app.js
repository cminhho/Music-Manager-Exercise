'use strict';

var musicManager = angular.module('musicManager', ['musicManager.songServices', 'musicManager.directives', 'localization', 'ngUpload', 'ngResource', 'ngGrid','ui.bootstrap']);

//Route 
musicManager.config(function ($routeProvider) {
    $routeProvider.otherwise({
            templateUrl: 'partials/list.html',
            controller: 'ListCtrl',
            redirectTo: '/'
        });
});
