// 최근 본 레시피 저장
let contextPath = document.body.dataset.contextPath
let rView = JSON.parse(localStorage.getItem('rView')) || []
const recipeId = document.body.dataset.recipeId
const recipeImg = document.body.dataset.recipeImg

const newItem = { id: recipeId, img: recipeImg }
const existingItemIndex = rView.findIndex((item) => item.id === recipeId);

if (existingItemIndex === -1) { // 없을 때
    if (rView.length > 9) {
        rView.pop()
    }
} else { // 있을 때
    rView.splice(existingItemIndex, 1)
}
rView.unshift(newItem)
localStorage.setItem('rView', JSON.stringify(rView))
// 최근 본 레시피 저장 끝

// 최근 본 레시피 목록
let vhDiv = document.getElementById('view-history')
let rViewLen = Math.min(rView.length, 5)
let historyDiv = document.createElement('div')
historyDiv.classList.add('list-group')
let hhDiv = document.createElement('div')
hhDiv.classList.add('list-group-item')
hhDiv.classList.add('disabled')
hhDiv.classList.add('text-center')
hhDiv.innerHTML = '최근 본 레시피'
historyDiv.appendChild(hhDiv)

for (i = 0; i < rViewLen; i++) {
    let newA = document.createElement('a')
    newA.classList.add('list-group-item')
    newA.classList.add('list-group-item-action')
    newA.href = contextPath + '/recipe/detail.do?recipeId=' + rView[i].id

    let newDiv = document.createElement('div')
    newDiv.classList.add('history-img-container')

    let newImg = document.createElement('img')
    newImg.setAttribute('src', rView[i].img)

    newDiv.appendChild(newImg)
    newA.appendChild(newDiv)
    historyDiv.appendChild(newA)
}
vhDiv.appendChild(historyDiv)
// 최근 본 레시피 목록 끝