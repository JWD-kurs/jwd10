var wafepaApp = angular.module('wafepaApp.controllers', []);

wafepaApp.controller('ActivityController', function($scope, $location, $routeParams, activityRestService) {
	
	$scope.getActivities = function() {
		var request_params = {name: $scope.name, page: $scope.page};
		activityRestService.getActivities(request_params)
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
		activityRestService.deleteActivity(id)
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
			activityRestService.getActivity($routeParams.id)
					.success(function(data) {
						$scope.activity = data;
					})
					.error(function() {
						
					});
		}
	};
	
	$scope.saveActivity = function() {
		activityRestService.saveActivity($scope.activity)
			.success(function() {
				$location.path('/activities');
			})
			.error(function() {
				
			});
	};
});

wafepaApp.controller('LogController', function($scope, $http, $location) {
	
	$scope.getLogs = function() {
		$http.get('api/logs')
				.success(function(data) {
					$scope.logs = data;
					$scope.success = true;
				})
				.error(function() {
					
				});
	};
	
	$scope.initLog = function() {
		$scope.log = {};
		
		// dobavi sve aktivnosti za select option (page -1 dobavlja sve)
		$http.get('api/activities', { params : { page : -1 }})
				.success(function(data) {
					$scope.activities = data;
				})
				.error(function() {
					
				});
	};
	
	$scope.saveLog = function() {
		$http.post('api/logs', $scope.log)
				.success(function() {
					$location.path('/logs');
				})
				.error(function() {
					
				});
	};
});