//lets use fetch to dynamically create content on the states-practice.html page
fetch('/states')
	.then(response => response.json())
	.then(jsonData => {
		
		const container = document.querySelector('.container');
		
		console.log(jsonData);
		
		jsonData.forEach(state => {
			const stateName = state.name;
			console.log(stateName);
			
/*			const stateNameElem = document.createElement('h2');
			stateNameElem.innerHTML = stateName;
			container.appendChild(stateNameElem);
			
			const mottoNameElem = document.createElement('p');
			mottoNameElem.innerHTML = `motto: ${state.motto}`;
			container.appendChild(mottoNameElem);*/
			
			container.innerHTML += `
				<h2>${state.name}</h2>
				<p>motto: ${state.motto}</p>
			`;
			
			const citiesLinks = state.citiesUrl;
			citiesLinks.forEach(city =>{
				
				const cityLinkElem = document.createElement('li');
				cityLinkElem.innerHTML = `<a href=${city}>${city}</a>`;
				container.appendChild(cityLinkElem);
			})
			
		})
	})
	
	.catch(err => console.log(err));





