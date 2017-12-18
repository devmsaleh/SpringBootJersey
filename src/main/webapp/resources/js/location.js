/**
 * 
 */

var currentMarker = null;

function findMe(updateMarker,formId) {
	
	navigator.geolocation
				.getCurrentPosition(
						function(position) {
							
							var map = PF('gmap').getMap(), latlng = new google.maps.LatLng(
									position.coords.latitude,
									position.coords.longitude);
							
							var lat=document.getElementById(formId+':lat').value;
							var lng=document.getElementById(formId+':lng').value;
							
							var update=0;
							
							if (currentMarker === null) {
							
							if(lat !='' && lng !=''){
								latlng = new google.maps.LatLng(lat,lng);
								update =1;
							}
							
							map.setCenter(latlng);

							currentMarker = new google.maps.Marker({
								position : latlng,
								map: map,
								draggable : true
								
							});

							
							google.maps.event.addListener(currentMarker, 'dragend', function (event) {
										
										geocodePosition(currentMarker.getPosition(),formId);
										document.getElementById(formId+':lat').value = currentMarker.getPosition().lat().toFixed(6);
										document.getElementById(formId+':lng').value = currentMarker.getPosition().lng().toFixed(6);
										
									});
							
							}else{
								if(updateMarker){
									currentMarker.setPosition(latlng);
								}
							}
							
							
							// get String location
							geocodePosition(currentMarker.getPosition(),formId);
							
							if(update == 0){
								document.getElementById(formId+':lat').value = position.coords.latitude;
								document.getElementById(formId+':lng').value = position.coords.longitude;
							}
							
						}, function(error) {
							alert(error.message);
						}, {
							enableHighAccuracy : true
						});
	
}

function handlePointClick(event,fromId) {
    if(currentMarker === null) {
        
        currentMarker = new google.maps.Marker({
            position:new google.maps.LatLng(event.latLng.lat(), event.latLng.lng()),
            draggable :true
        });
        
		google.maps.event.addListener(currentMarker, 'dragend', function (event) {
			
			geocodePosition(currentMarker.getPosition(),formId);
			document.getElementById(formId+':lat').value = currentMarker.getPosition().lat().toFixed(6);
			document.getElementById(formId+':lng').value = currentMarker.getPosition().lng().toFixed(6);
			
		});


        PF('gmap').addOverlay(currentMarker);
        
        document.getElementById(fromId+':lat').value = event.latLng.lat();
        document.getElementById(fromId+':lng').value = event.latLng.lng();
    }   
}

function geocodePosition(pos,formId) {
	  var geocoder= new google.maps.Geocoder();
	  geocoder.geocode({
	    latLng: pos
	  }, function(responses) {
	    if (responses && responses.length > 0) {
	      updateMarkerAddress(responses[0].formatted_address,formId);
	    } else {
	      updateMarkerAddress('Cannot determine address at this location.');
	    }
	  });
	}

function updateMarkerAddress(address,fromId){
	document.getElementById(fromId+':locationDescription').value=address;
	document.getElementById(fromId+':locationDescriptionDialog').value=address;
	
}