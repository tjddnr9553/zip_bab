const wrBtn = document.getElementById('write-review')
wrBtn.addEventListener('click', (event) => {
    const wrFormDiv = document.getElementById('write-review-form')
    wrFormDiv.classList.toggle('d-none')
})

const erBtn = document.querySelectorAll('.edit-review-btn')
erBtn.forEach((ele) => {
    ele.addEventListener('click', (event) => {
        let reviewId = parseInt(ele.getAttribute('val'))
        const erFormDiv = document.getElementById(`edit-review-form-${reviewId}`)
        erFormDiv.classList.toggle('d-none')
    })
})

const erForm = document.querySelectorAll('.er-form')

erForm.forEach((ele) => {
    ele.addEventListener('submit', (event) => {
        event.preventDefault()
        let req = new XMLHttpRequest()
        let recipeId = ele.recipeId.value
        let reviewId = ele.reviewId.value
        let content = ele.content.value

        let param = 'content=' + content + '&recipeId=' + recipeId +'&reviewId=' + reviewId

        req.open('POST', contextPath + '/review/edit.do')
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        req.send(param)

        req.onload = function () {
            let res = req.responseText
            let obj = JSON.parse(res)

            if (obj['result']) {
                const rContentDiv = document.getElementById('review-content-' + reviewId)
                const erFormDiv = document.getElementById(`edit-review-form-${reviewId}`)

                rContentDiv.innerHTML = obj['content']
                erFormDiv.classList.add('d-none')
            } else {
                alert(obj['message'])
            }
        }
    })
})

const delForms = document.querySelectorAll('.del-review-form')

delForms.forEach((ele) => {
    ele.addEventListener('submit', (event) => {
        event.preventDefault()
        let req = new XMLHttpRequest()
        let recipeId = ele.recipeId.value
        let reviewId = ele.reviewId.value

        let param = 'recipeId=' + recipeId +'&reviewId=' + reviewId

        req.open('POST', contextPath + '/review/delete.do')
        req.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        req.send(param)

        req.onload = function () {
            const rReviewDiv = document.getElementById('review-item-' + reviewId)
            rReviewDiv.remove()
        }
    })
})