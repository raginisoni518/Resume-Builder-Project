document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('sign-in-btn');
    registerButton.addEventListener('click', async () => {
        const email = document.getElementById('email').value;
       const password=document.getElementById('password').value;

        const data = { email, password };

        try {
            const response = await fetch('check', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (!response.ok) {
                const errorData = await response.json();
                alert(errorData.message || 'incorrect email or password');
            } else {
				console.log("success");
               window.location.href = 'personalDetails'; 
               
            }
        } catch (error) {
            alert('An error occurred. Please try again.');
        }
    });
});