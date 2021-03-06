var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('ActivityController', function($scope, $http, $location, $routeParams) {
	
	$scope.getActivities = function() {
		var request_params = {name: $scope.name, page: $scope.page};
		$http.get('api/activities', { params:  request_params })
				.success(function(data, status, headers) {
					$scope.activities = data;
					$scope.totalPages = headers('total-pages');
					$scope.success = true;
				})
				.error(function() {
					alert('Oops, something went wrong!');
				});
	};
	
	$scope.deleteActivity = function(id) {
		$http.delete('api/activities/' + id)
				.success(function() {
					$scope.getActivities();
				})
				.error(function() {
					
				});
	};
	
	$scope.initActivity = function() {
		$scope.activity = {};
		
		if ($routeParams && $routeParams.id) {
			// ovo je edit stranica
			$http.get('api/activities/' + $routeParams.id)
					.success(function(data) {
						$scope.activity = data;
					})
					.error(function() {
						
					});
		}
	};
	
	$scope.saveActivity = function() {
		if ($scope.activity.id) {
			// edit stranica
			$http.put('api/activities/' + $scope.activity.id, $scope.activity)
				.success(function() {
					$location.path('/activities');
				})
				.error(function() {
					
				});
		} else {
			// add stranica
			$http.post('api/activities', $scope.activity)
				.success(function() {
					$location.path('/activities');
				})
				.error(function() {
					
				});
		}
	};
});

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'static/html/home.html'
        })
        .when('/activities', {
        	templateUrl : 'static/html/activities.html',
        	controller: 'ActivityController'
        })
        .when('/activities/add', {
        	templateUrl : 'static/html/addEditActivity.html',
        	controller: 'ActivityController'
        })
        .when('/activities/edit/:id', {
        	templateUrl : 'static/html/addEditActivity.html',
        	controller: 'ActivityController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);