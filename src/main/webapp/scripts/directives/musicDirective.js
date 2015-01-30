'use strict';
angular.module('musicDirective',[])

  .directive('musicHeader', function(){
    return{
      restrict: 'E',
      templateUrl: 'views/music-header.html',
      controller: function(){
      }
    };
  })

  .directive('musicFooter', function(){
    return{
      restrict: 'E',
      templateUrl: 'views/music-footer.html'
    };
  })

  .directive('musicPath', function(){
    return{
      restrict: 'E',
      templateUrl: 'views/music-path.html',
      controller: function($scope){
        $scope.navs = [];
      }
    };
  })

  .directive('musicSidebar', function(){
    return{
      restrict: 'E',
      templateUrl: 'views/music-sidebar.html'
    };
  })

  //  sidr side menu the directive
  .directive( 'sideMenu', function () {
    return {
      scope:    true,
      restrict: 'E',
      template:
        '<a href id="nav-colum" class="navbar-brand" ng-click="toggle()" >' +
          ' <span id="header-nav" class="glyphicon glyphicon-align-justify"></span>' +
        '</a>',
      link: function (){
        var sidrMenu = angular.element('#nav-colum');
        sidrMenu.sidr({
          displace: false
        });

        $(window).resize(function(){
          var sidebar = angular.element('#sidr');
          var w = $(window).width();
          if(w> 480 && sidebar.is(':hidden')){
            sidebar.removeAttr('style');
          }
        });
      }
    };
  })

  //  Music table the directive
  .directive('musicTable', function(){
    return{
      scope:    true,
      restrict: 'E',
      templateUrl:'views/music-table.html',
      link: function(attrs){
       
      }
    };
  })

  .directive('musicSearch', function(){
    return{
      restrict:   'E',
      templateUrl: 'views/music-search.html',
      controller: function($scope){

        var btnCtrlRight  = angular.element('.btnCtrlRight'),
            btnSearch     = angular.element('.music-search');

        btnSearch.hide();

        var w           = $(window).width(),
            topArticle  = angular.element('.top-article'),
            searchTop   = angular.element('.search-top');
        searchTop.hide();

        $scope.clickSearch = function(){

          if(w < 385) {
            topArticle.hide();
            searchTop.show();
          }
          else{
            searchTop.hide();
            btnCtrlRight.hide();
            btnSearch.slideDown();
          }
        };

        $scope.clickRemove = function(){
          topArticle.show();
          btnCtrlRight.slideDown();
          btnSearch.hide();
          searchTop.hide();
        };

      }
    };
  });