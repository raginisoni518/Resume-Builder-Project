document.addEventListener('DOMContentLoaded', () => {
	const registerButton = document.getElementById('choice-btn');
	//const errorMessageDiv = document.getElementById('errorMessage');
	const skillCheck = document.getElementById('skillCheck');
	const bar = document.getElementById('file');
	
	
	registerButton.addEventListener('click', async () => {
		const list = document.getElementById('skill');
        for (let i = 0; i < list.children.length; i++) {
        let jobSearch =list.children[i].textContent;
        data={jobSearch};
        try {
			const response = await fetch('updateJob', {
				method: 'POST',
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
			    skillCheck.checked = true;
				bar.value = "89";
				window.location.href = 'getResume'; 
				//window.location.href='experience';
				// Optionally, redirect or perform any other action after a successful update
			}
		 }catch (error) {
			alert('An error occurred. Please try again.');
		}
      }
		

			
	});
});