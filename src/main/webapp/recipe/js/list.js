$(document).ready(function(){
    $('#search-title').on('click', function(){
        $('#search-input').attr('name', 'title')
        $('#search-input').val('')
        $('#search-type').html('이름')
        $('#search-title').addClass('active')
        $('#search-ingredient').removeClass('active')


    })

    $('#search-ingredient').on('click', function(){
        $('#search-input').attr('name', 'ingredient')
        $('#search-input').val('')
        $('#search-type').html('재료')
        $('#search-title').removeClass('active')
        $('#search-ingredient').addClass('active')
    })
})