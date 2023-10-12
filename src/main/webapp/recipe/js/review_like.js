let contextPath = document.body.dataset.contextPath

let likeBtns = document.querySelectorAll(".r-like-btn")
window.onload = () => {
    likeBtns.forEach((likeBtn) => {
        likeBtn.addEventListener('click', (event) => {
            let likeReq = new XMLHttpRequest()

            let reviewId = event.currentTarget.dataset.reviewId
            let param = 'reviewId=' + reviewId
            console.log(reviewId)

            likeReq.open('POST', contextPath + '/review/like.do')
            likeReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
            likeReq.send(param)

            likeReq.onload = function () {
                let res = likeReq.responseText
                console.log(res)
                let obj = JSON.parse(res)
                document.getElementById('like-cnt-'+reviewId).innerHTML = obj['cnt']
            }
        })
    })
}
