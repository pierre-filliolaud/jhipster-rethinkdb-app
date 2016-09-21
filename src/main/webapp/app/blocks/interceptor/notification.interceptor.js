(function() {
    'use strict';

    angular
        .module('rethinkdbjhipsterApp')
        .factory('notificationInterceptor', notificationInterceptor);

    notificationInterceptor.$inject = ['$q', 'AlertService'];

    function notificationInterceptor ($q, AlertService) {
        var service = {
            response: response
        };

        return service;

        function response (response) {
            var alertKey = response.headers('X-rethinkdbjhipsterApp-alert');
            if (angular.isString(alertKey)) {
                AlertService.success(alertKey, { param : response.headers('X-rethinkdbjhipsterApp-params')});
            }
            return response;
        }
    }
})();
