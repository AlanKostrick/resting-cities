const abbreviationInput = document.querySelector('#abbreviation');
const stateNameInput = document.querySelector('#stateName');
const addStateButton = document.querySelector('button');
const stateDisplay = document.querySelector('.stateDisplay');


addStateButton.addEventListener('click', () => {
	console.log(`/states/${abbreviationInput.value}/${stateNameInput.value}/add`)
	fetch(`/states/${abbreviationInput.value}/${stateNameInput.value}/add`, {
		method:'post',
		body: JSON.stringify({
			abbreviation: abbreviationInput.value,
			stateName: stateNameInput.value,
		}),
		
	})
	
		.then(res => res.json())
		.then(data => {
			
			while (stateDisplay.hasChildNodes()) {   
			    stateDisplay.removeChild(stateDisplay.firstChild);
			}

			
		data.forEach(state => {
			const stateName = state.name;
			const stateAbbreviation = state.abbreviation;
			const stateNameElem = document.createElement('li');
			stateNameElem.innerText = `${stateAbbreviation}:  ${stateName}`;
			stateDisplay.appendChild(stateNameElem);
			
		})
		
	});
		
		
})






