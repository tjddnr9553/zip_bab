let contextPath = document.body.dataset.contextPath

const wrBtn = document.getElementById('write-review')
wrBtn.addEventListener('click', (event) => {
    const wrForm = document.getElementById('write-review-form')
    wrForm.classList.toggle('d-none')
})

