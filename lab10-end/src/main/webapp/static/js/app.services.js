var wafepaApp = angular.module('wafepaApp.services', []);

wafepaApp.service('activityRestService', function($http) {
	
	this.apiUrl = 'api/activities';
	
	this.getActivity = function(id) {
		return $http.get(this.apiUrl + '/' + id);
	};
	
	this.getActivities = function(request_params) {
		return $http.get(this.apiUrl, { params: request_params });
	};
	
	this.deleteActivity = function(id) {
		return $http.delete(this.apiUrl + '/' + id);
	};
	
	this.saveActivity = function(activity) {
		if (activity.id) {
			return $http.put(this.apiUrl + '/' + activity.id, activity);
		} else {
			return $http.post(this.apiUrl, activity);
		}
	};
});