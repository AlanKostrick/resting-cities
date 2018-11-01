const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		const res = JSON.parse(xhr.response);
		const container = document.querySelector('.container')
		
		console.log({ res })

		res.forEach(function(state) {
			const stateItem = document.createElement('div');
			const stateInfo = document.createElement('ul');

			const name = document.createElement('h2');
			name.innerText = state.name;
			const abbr = document.createElement('li');
			abbr.innerText = `Abbreviation: ${state.abbreviation}`;
			const motto = document.createElement('li');
			motto.innerText = `Motto: ${state.motto}`;
			const fish = document.createElement('li');
			fish.innerText = `Fish: ${state.fish}`;
			
			const cityUrls = [];
			state.citiesUrl.forEach(cityUrl => {
				const cityUrlElem = document.createElement('li');
				cityUrlElem.innerHTML = `City URL: <a href="${cityUrl}">${cityUrl}</a>`;
				cityUrls.push(cityUrlElem);
			});
			
			container.appendChild(stateItem);
			
			stateItem.appendChild(name);
			stateItem.appendChild(stateInfo);
			
			stateInfo.appendChild(abbr);
			stateInfo.appendChild(motto);
			stateInfo.appendChild(fish);
			
			cityUrls.forEach(cityUrl => stateInfo.appendChild(cityUrl));
		})
	}
}

xhr.open('GET', 'http://localhost:8080/states', true)
xhr.send()