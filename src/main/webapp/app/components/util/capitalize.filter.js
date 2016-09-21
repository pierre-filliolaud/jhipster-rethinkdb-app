(function() {
    'use strict';

    angular
        .module('rethinkdbjhipsterApp')
        .filter('capitalize', capitalize);

    function capitalize() {
        return capitalizeFilter;

        function capitalizeFilter (input) {
            if (input !== null) {
                input = input.toLowerCase();
            }
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
    }
})();
