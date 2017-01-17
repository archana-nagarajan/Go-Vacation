angular.module('placesList').component('placesList',{
    templateUrl: 'resources/places-list/places-list.template.html',
    controller: function($http,$routeParams){
        // document.getElementById('locality-text').innerHTML = $routeParams.locality;
        // document.getElementById('category-text').innerHTML = $routeParams.category;
    	var resource_url = "/GoVacation/"+$routeParams.category+"/"+$routeParams.locality
    	console.log("res_url:"+resource_url);
    	this.url = ""
    	this.location = $routeParams.locality;
    	this.category = $routeParams.category;
        self = this;
        $http.get(resource_url).then(function(response) {
            self.items = response.data;
            
            var total_long = 0;
            var total_lat = 0;
            var locations = [];
            for(var i=0;i<self.items.length;++i){
                var item = self.items[i];
                var location = [];
                location.push(item.locationName);
                location.push(item.latitude);
                location.push(item.longitude);
                locations.push(location);
                total_long = total_long+item.longitude;
                total_lat = total_lat+item.latitude;
            }
            mean_longitude = total_long/self.items.length;
            mean_latitude = total_lat/self.items.length;

            map = new google.maps.Map(document.getElementById('map'),{ center: {lat: mean_latitude, lng: mean_longitude}, zoom: 8});
            
            var infowindow = new google.maps.InfoWindow();

            var marker, i;

            for (i = 0; i < locations.length; i++) {  
                marker = new google.maps.Marker({
                    position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                    map: map
                });

                google.maps.event.addListener(marker, 'click', (function(marker, i) {
                    return function() {
                    infowindow.setContent(locations[i][0]);
                    infowindow.open(map, marker);
                    }
                })(marker, i));
            }

        });
        
        this.setItem = function(item){
        	this.item = item;
        };

        // map = new google.maps.Map(document.getElementById('map'),{ center: {lat: -34.397, lng: 150.644}, zoom: 8});
        // var locations = [
        //     ['Bondi Beach', -33.890542, 151.274856, 4],
        //     ['Coogee Beach', -33.923036, 151.259052, 5],
        //     ['Cronulla Beach', -34.028249, 151.157507, 3],
        //     ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
        //     ['Maroubra Beach', -33.950198, 151.259302, 1]
        // ];
    
        // var map = new google.maps.Map(document.getElementById('map'), {
        //     zoom: 10,
        //     center: new google.maps.LatLng(-33.92, 151.25),
        //     mapTypeId: google.maps.MapTypeId.ROADMAP
        // });

        

        

        // this.name = "abc";
    }
    
});