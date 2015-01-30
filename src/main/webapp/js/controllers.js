'use strict';

/* Controllers */

//Default Controller
musicManager.controller('MainCtrl', function($scope, $location, localize,$dialog){

    //change language
    $scope.langs= [
        {id:'en-US', name:'English'},
        {id:'vi-VN', name:'Vietnamese'}
    ];

    $scope.user = {
        name : 'Admin',
        imgUrl : 'img/avatar.png',
        language: $scope.langs[0],
        pageSize: 10
    };

    $scope.selectedLang=$scope.user.language;

    $scope.changeLang = function() {
        localize.setLanguage($scope.selectedLang.id);
    };

    $scope.go = function (url) {
        $location.url(url);
    };

     //dialog add
    $scope.openAddDialog = function(){
        var d = $dialog.dialog({
                      backdrop: true,
                      keyboard: true,
                      backdropClick: true,
                      templateUrl: 'partials/add.html',
                      controller: 'AddCtrl'
                  });
        d.open();
    };

    //dialog detail
    $scope.openDetailDialog = function(song){
        var d = $dialog.dialog({
                      backdrop: true,
                      keyboard: true,
                      backdropClick: true,
                      templateUrl: 'partials/detail.html',
                      controller: 'DetailCtrl',
                      resolve: {song: function(){ return angular.copy(song); }}
                  });
        d.open();
    };

    //dialog edit
    $scope.openEditDialog= function(song){
        var d = $dialog.dialog({
                      backdrop: true,
                      keyboard: true,
                      backdropClick: true,
                      templateUrl: 'partials/edit.html',
                      controller: 'DetailCtrl',
                      resolve: {song: function(){ return angular.copy(song); }}
                  });
        d.open();
    };

});

//List Controller
musicManager.controller('ListCtrl', function($scope,$rootScope,$routeParams, $resource, $location, Song){

    $scope.songs = [];

    //data config for ng-grid
    $scope.buttonsTemplate = '<div class="actionCell">\
                              <i class="icon-play-circle" title="Play" ng-click="onPlayClick($event, row)"></i>&nbsp;&nbsp;\
                              <i class="icon-pencil" title="Edit" ng-click="onEditClick($event, row)"></i>&nbsp;&nbsp;\
                              <i class="icon-remove" title="Delete" ng-click="onDeleteClick($event, row)"></i>\
                              </div>';

    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: false
    };

    $scope.pagingOptions = {
        pageSizes: [5, 10, 20, 50],
        pageSize: $scope.user.pageSize,
        totalServerItems: 0,
        currentPage: 1
    };

    // load data function
    $scope.getPagedDataAsync = function (pageSize, page) {
        var start = pageSize * (page - 1);
        Song.queryPaging({start: start, max: pageSize}, function (songs) {
            $scope.songs = songs.content;
            $scope.gridOptions.selectedItems.length = 0;
            
            if (!$scope.$$phase) {
                $scope.$apply();
            }
        });
    };

    // load data
    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        if (newVal !== oldVal && (newVal.currentPage !== oldVal.currentPage || newVal.pageSize !== oldVal.pageSize)) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
            $scope.user.pageSize = $scope.pagingOptions.pageSize;
        }
    }, true);

    $scope.$watch('query', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.filterOptions.filterText=$scope.query;
        }
    }, true);

    $scope.gridOptions = {
        totalServerItems: $scope.songs.length,
        data: 'songs',
        showFooter: true,
        showHeader: true,
        showSelectionCheckbox: true,
        enablePaging: true,
        enableHighlighting: false,
        enableRowReordering: true,
        enableColumnResize: true,
        plugins: [
            new ngGridFlexibleHeightPlugin({ minHeight: 400 })
        ],
        columnDefs: [
            {
                displayName: 'Name',
                field: 'name',
                width: '480px'
            },
            {
                displayName: 'Genre',
                field: 'genre'
            },
            {
                displayName: 'Actions',
                sortable: false,
                cellTemplate: $scope.buttonsTemplate
            }
        ],
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions,
        selectedItems: []
    };

    $scope.onPlayClick = function($event, row) {
        $scope.openDetailDialog(row.entity);
        $event.stopPropagation();
    };

    $scope.onEditClick = function($event, row) {
        $scope.openEditDialog(row.entity);
        $event.stopPropagation();
    };

    $scope.onDeleteClick = function($event, row) {
        row.entity.$delete({songId:row.entity.id}, function() {
            // reload data
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
        });
        $event.stopPropagation();
    };

    $scope.delete = function(songs) {
        var count = 0;
        for(var i in songs) {
            songs[i].$delete({songId:songs[i].id}, function () {
                count++;
                if(count == songs.length){
                    // reload data
                    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
                    console.log("reload songs");
                }
            });
        }
    }

    // listen event
    if (typeof(EventSource) !== "undefined") {
        // Yes! Server-sent events support!
        var source = new EventSource("resources/song/events");
        source.onmessage = function (event) {
            console.log('Received unnamed event: ' + event.data);
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
        };

        source.addEventListener("song", function(event) {
            console.log('Received event: ' + event.data);
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

        }, false);

        source.onopen = function (event) {
            console.log("event source opened");
        };

        source.onerror = function (event) {
            console.log('Received error event: ' + event);
        };
    }

});

//Details Controller (/song/:id)
musicManager.controller('DetailCtrl', function($scope, $routeParams, $location, $dialog, dialog, song){
    $scope.item = song;

    $scope.update = function(song) {
        //song.$save();
        song.$update({songId: song.id});

        dialog.close(song);
        $scope.$destroy();
    }

    $scope.delete = function(song) {
        song.$delete({songId:song.id}, function() {
            //close dialog
            dialog.close("deletedSong");
            $scope.$destroy();
        });
    }
    $scope.close = function(){
        dialog.close();
        $scope.$destroy();
    };
    
    //dialog edit
    $scope.openEditDialog= function(song){
        var d = $dialog.dialog({
                      backdrop: true,
                      keyboard: true,
                      backdropClick: true,
                      templateUrl: 'partials/edit.html',
                      controller: 'DetailCtrl',
                      resolve: {song: function(){ return angular.copy(song); }}
                  });
        d.open().then(function(updatedSong) {
            if (typeof(updatedSong) !== 'undefined') {
                if (updatedSong === "deletedSong") {
                    dialog.close();
                } else {
                    $scope.item = updatedSong;
                }
            }
        });
    };

});

//Add Song Controller
musicManager.controller('AddCtrl', function($scope, $routeParams,$location,dialog){
    $scope.song = {};

    $scope.uploadFile = function(content, completed) {
        console.log("_______________ IN UPLOAD _____________");
        console.log("completed: " + completed+ "-------------------->content: " + content);
        if (completed && content.length > 0) {
            console.log("upload completed!");

            $location.url("/");
            dialog.close();
            $scope.$destroy();
        }
    };
    $scope.close = function(){
        dialog.close();
        $scope.$destroy();
    };

});
