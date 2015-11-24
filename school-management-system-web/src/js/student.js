function Student($scope, $http) {
    $http.get('http://localhost:8080/students/1').
        success(function(data) {
            $scope.welcome = data;
        });
}