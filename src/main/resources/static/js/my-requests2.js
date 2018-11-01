const stateAddButton = document.querySelector('.add-state button'),
	abbreviationAddInput = document.getElementById("abbreviation"),
	stateAddInput = document.getElementById("stateName"),
	statesList = document.querySelector('.states-list ul')

const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = xhr.responseText
		statesList.innerHTML = res
	}
}

stateAddButton.addEventListener('click', function() {
	postStates(abbreviationAddInput.value, stateAddInput.value)
	stateAddInput.value = ""
})


function postStates(abbreviation, stateName) {
	xhr.open('POST', '/show-states/' + abbreviation + '/' + stateName, true)
	xhr.send()
}

