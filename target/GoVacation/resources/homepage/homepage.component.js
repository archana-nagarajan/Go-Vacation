angular.module('homepage').component('homepage',{
    templateUrl: 'resources/homepage/homepage.template.html',
    controller: function(){
        var self = this;
        places = new google.maps.places.Autocomplete(document.getElementById('txtPlaces'));
        places.addListener('place_changed', function() {         
            self.place = places.getPlace();
            place = self.place;
            for(var i = 0; i < self.place.address_components.length ;++i){
                if(self.place.address_components[i].types[0] == "locality"){
                    self.locality = self.place.address_components[i].long_name;
                    locality = self.locality;
                }
            }
        });

        self.search = function(){
        	console.log('#!/'+self.locality+'/'+self.category);
            window.location.hash = '#!/places/locality/'+self.locality+'/category/'+self.category;
        }

        self.setCategory = function(categoryNumber){
            if( categoryNumber == 1 ){
                self.category = 'landmarks';
            }
            else if( categoryNumber == 2 ){
                self.category = 'restaurants'; 
            }
            else if( categoryNumber == 3 ){
                self.category = 'accommodations';
            }
            else if( categoryNumber == 4 ){
                self.category = 'activities';
            }
            else if( categoryNumber == 5 ){
                self.category = 'locations';
            }
            self.search()            
        }
    }
});