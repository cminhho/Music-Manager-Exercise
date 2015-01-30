'use strict';
(function(){
	angular.module('musicManager', [
		'plunker',
		'musicFactory',
		'musicCtrl',
		'musicDirective',
		'ui.bootstrap',
		'ngRoute'
  ]
  )
	.config(function($routeProvider){
		$routeProvider
		.when('/',{
			controller: 'MainCtrl',
			templateUrl: 'views/music-main.html'
		})
    .when('/songs',{
      controller: 'MainCtrl',
      templateUrl: 'views/music-main.html'
    })
		.when('/new',{
			controller: 'CreateCtrl',
			templateUrl: 'views/detail.html'
		})
		.when('/edit/:id',{
			controller: 'EditCtrl',
			templateUrl: 'views/detail.html'
		})
    .when('/playlists',{
      controller: 'PlaylistsCtrl',
      template: 'Playlists'
    })
		.otherwise({
			redirecTo: '/songs'
		});
	})
	
	//Add this to have access to a global variable
	.run(function ($rootScope, songs) {
		//global variable
		songs.list(function(data) {
		  $rootScope.list = data;
    });
	});
	
})();
