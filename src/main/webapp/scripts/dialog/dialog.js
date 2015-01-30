'use strict';
angular.module('plunker', []);

var ModalInstanceCtrl;
ModalInstanceCtrl = function ($scope, $modalInstance, title, message, count) {

  $scope.title = title;
  $scope.message = message;
  $scope.itemNotFound = true;
  if (count > 1) {
    $scope.title = 'Delete multiple songs';
    $scope.message = 'Are you sure you want to delete selected songs?';
  }
  $scope.ok = function () {
    $modalInstance.close();
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
};

var ModalDemoCtrl;
ModalDemoCtrl = function ($scope, $modal, $log) {

  var vTitle = 'Delete a song';
  var vMessage = 'Are you sure you want to delete this song?';
  $scope.isAll = false;
  $scope.tableSelection = {};
  $scope.btnDelete = true;

  for (var i = $scope.list.length - 1; i >= 0; i--) {
    if ($scope.list[i].done) {
      $scope.btnDelete = false;
      break;
    }
  }
  for (var j = $scope.list.length - 1; j >= 0; j--) {
    $scope.isAll = true;
    if (!$scope.list[j].done) {
      $scope.isAll = false;
      break;
    }
  }
  $scope.countClick = function (index) {

    if($scope.list[index].done){
      $scope.btnDelete = true;
      delete $scope.list[index].done ;
      for (var i = $scope.list.length - 1; i >= 0; i--) {
        if ($scope.list[i].done) {
          $scope.btnDelete = false;
          //break;
        }
        else{
          $scope.isAll = false;
        }
      }
    }
    else{
      $scope.btnDelete = false;
    }

  };

  // Select all rows
  $scope.selectAllRows = function () {
    if ($scope.isAll === true) {
      for (var i = $scope.list.length - 1; i >= 0; i--) {
        $scope.list[i].done = false;
      }
      $scope.isAll = false;
      // Show delete button
      $scope.btnDelete = true;
    }
    else {
      for (var u = $scope.list.length - 1; u >= 0; u--) {
        $scope.list[u].done = true;
      }
      $scope.isAll = true;
      // Show delete button
      $scope.btnDelete = false;
    }
  };

  // Remove selected rows
  $scope.removeSelectedRows = function () {
    var modalInstance = $modal.open({
      templateUrl: 'views/dialog.html',
      controller: ModalInstanceCtrl,
      size: 'lg',
      resolve: {
        title: function () {
          return vTitle;
        },
        message: function () {
          return vMessage;
        },
        count: function () {
          var iCount = 0;
          //if(iCount<2){
          for (var i = $scope.list.length - 1; i >= 0; i--) {
            if ($scope.list[i].done) {
              iCount++;
            }
          }
          //}
          return iCount;
        }
      }
    });

    modalInstance.result.then(function () {

      for (var i = $scope.list.length - 1; i >= 0; i--) {
        if ($scope.list[i].done) {
          $scope.list.splice(i, 1);
        }
      }
//      var oldList = $scope.list;
//      $scope.list = [];
//      angular.forEach(oldList, function(item) {
//        if (!item.done) $scope.list.push(item);
//        else{
//          delete item;
//        }
//      });
      $scope.btnDelete = true;
      $scope.isAll = false;

    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
  };

  // Remove a row
  $scope.remove = function (item) {
    var modalInstance = $modal.open({
      templateUrl: 'views/dialog.html',
      controller: ModalInstanceCtrl,
      size: 'lg',
      resolve: {
        title: function () {
          return vTitle;
        },
        message: function () {
          return vMessage;
        },
        count: function () {
          return 1;
        }
      }
    });

    modalInstance.result.then(function () {

      var index = $scope.list.indexOf(item);
      $scope.list.splice(index, 1);
      $scope.btnDelete = true;
      for (var i = $scope.list.length - 1; i >= 0; i--) {
        if ($scope.list[i].done) {
          $scope.btnDelete = false;
          break;
        }
      }
//      for (var i = $scope.list.length - 1; i >= 0; i--) {
//        if ($scope.list[i].done) {
//          $scope.btnDelete = false;
//          $scope.k = $scope.k - 1;
//          break;
//        }
//      }
    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
  };
};

// Please note that $modalInstance represents a modal window (instance) dependency.
// It is not the same as the $modal service used above.

