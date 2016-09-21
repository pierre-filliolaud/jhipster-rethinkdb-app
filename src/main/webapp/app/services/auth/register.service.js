(function () {
    'use strict';

    angular
        .module('rethinkdbjhipsterApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
