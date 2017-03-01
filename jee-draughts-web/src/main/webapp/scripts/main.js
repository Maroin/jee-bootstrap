'use strict';

angular.module('DraughtsAngularApp', [])
  .controller('MainCtrl', ['$scope','$http', function($scope,$http) {
    $http({url:apiEndpoint,method:'GET'}).success(
      function(data) {
        $scope.game=data;
      }
    );
    $scope.play = function(col) {

    };

  }]) ;
