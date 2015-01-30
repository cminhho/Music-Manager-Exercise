'use strict';

/* Services */

angular.module('musicManager.songServices', ['ngResource'])
    .factory('Song', function($resource) {
        return $resource('api/song/:songId' , {} , {
            querySearching: {method:'GET', params:{q:'q'}, isArray: false},
            queryPaging: {method: 'GET', params: {page: 'page', size: 'size'}, isArray: false},
            update: {method:'PUT'}
        });
    });
