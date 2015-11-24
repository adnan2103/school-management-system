function Student($scope, $http) {
    $http.get('http://localhost:8080/students/2').
        success(function(data) {
            $scope.welcome = data;
        });
}