'use strict';
angular.module('musicFactory',[])
	.factory('songs', function($http){
    function getData(callback){
      $http({
        method: 'GET',
        url: 'store-musics.json',
        cache: true
      }).success(callback);
    }
    function getFind(name, callback){
      getData(function(data) {
        var music;
        music = data.filter(function (entry) {
          return entry.name === name;
        })[0];
        callback(music);
      });
    }
    return {
      list: getData,
      find: getFind
    };
  });