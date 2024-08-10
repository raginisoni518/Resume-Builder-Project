document.addEventListener('DOMContentLoaded', () => {
	const registerButton = document.getElementById('choice-btn');
	//const errorMessageDiv = document.getElementById('errorMessage');
	const experience = document.getElementById('experience');
	const bar = document.getElementById('file');
	
	
	
	registerButton.addEventListener('click', async () => {
		const title = document.getElementById('title').value;
		const purpose = document.getElementById('purpose').value;
		
		const projectLocation = document.getElementById('projectLocation').value;
        const selectStartMonth = document.getElementById('startMonth');
	const selectEndMonth = document.getElementById('endMonth');
	const selectStartYear = document.getElementById('startYear');
	const selectEndYear = document.getElementById('endYear');
	const description=document.getElementById('description').value;
	let startMonth = selectStartMonth.value;
	let startYear = selectStartYear.value;
	let endMonth = selectEndMonth.value;
	let endYear = selectEndYear.value;
	selectStartMonth.addEventListener('change', (event) => {
		startMonth = event.target.value;
	});
	selectStartYear.addEventListener('change', (event) => {
		startYear = event.target.value;
	});
	selectEndMonth.addEventListener('change', (event) => {
		endMonth = event.target.value;
	});
	selectEndYear.addEventListener('change', (event) => {
		endYear = event.target.value;
	});
		const data = { title, purpose, projectLocation, startMonth,startYear,endMonth,endYear,description};
        
		try {
			const response = await fetch('updateExperience', {
				method: 'PATCH',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(data)
			});

			if (!response.ok) {
				const errorData = await response.json();
				alert(errorData.message || 'An error occurred. Please try again.');
			} else {
				console.log("success");
			experience.checked = true;
				bar.value = "69";
				window.location.href='skills';
				
				// Optionally, redirect or perform any other action after a successful update
			}
		} catch (error) {
			alert('An error occurred. Please try again.');
		}
	});
});