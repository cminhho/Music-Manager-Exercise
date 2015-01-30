'use strict';

/* Services */

angular.module('musicManager.songServices', ['ngResource'])
    .factory('Song', function($resource) {
        return $resource('api/song/:songId' , {} , {
            query: {method:'GET', params:{songId:'all'}, isArray:true},
            queryPaging: {method: 'GET', params: {page: 'page', size: 'size'}, isArray:false},
            update: {method:'PUT'}
        });
    });
