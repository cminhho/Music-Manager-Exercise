'use strict';
(function(){
  angular.module('musicCtrl',[])
    .controller('CreateCtrl', function($scope, $location){
      $scope.btnApply   = false;
      $scope.btnCreate  = true;
      $scope.name       = 'Create song';
      $scope.dataWord   = false;

      // Add music path
      $scope.navs.push('Create song');

      $scope.save = function(){
        $location.path('/');
      };
	  $scope.cancel = function(){
        $location.path('/');
      };

      $scope.addSong = function(music){
        var len   = $scope.list.length - 1;
        music.id  = $scope.list[len].id + 1;

        if(!$scope.list.length){
          delete $scope.list;
        }
        $scope.list.push(music);
        $location.path('/');
      };
    })

    .controller('MainCtrl', function ($scope){
      $scope.checkAll = false;

      for(var k = $scope.navs.length; k >=0; k--){
        $scope.navs.splice(k,1);
      }

      $scope.navs.push('Songs');

      $scope.remaining = function() {
        var count = 0;
        angular.forEach($scope.list, function(item) {
          count += item.done ? 0 : 1;
        });
        return count;
      };
    })

    .controller('PlaylistsCtrl', function ($scope){
      for(var k = $scope.navs.length; k >=0; k--){
        $scope.navs.splice(k,1);
      }
      $scope.navs.push('Playlists');
    })

    .controller('EditCtrl', function ($scope, $location, $routeParams){
      //$scope.name = $routeParams.name;
      $scope.btnApply   	= true;
      $scope.btnCreate  	= false;
      var 	id            	= $routeParams.id,
			name 			= '',
			artist			= '';
      // Add music path
      $scope.navs.push('Edit song');

      for(var i = $scope.list.length - 1; i >= 0; i--){
        if(angular.equals($scope.list[i].id+'', id)){
          $scope.music = $scope.list[i];
          $scope.name = $scope.list[i].name;
		  name = $scope.list[i].name;
		  artist = $scope.list[i].artist;
          break;
        }
      }
      $scope.save = function() {
        $location.path('/');
      };
	  $scope.cancel = function() {
		$scope.list[i].name = name;
		$scope.list[i].artist = artist;
        $location.path('/');
      };
    });

})();