(function ($) {
  "use strict";
  // TOP Menu Sticky
  $(window).on('scroll', function () {
    var scroll = $(window).scrollTop();
    if (scroll < 400) {
      $("#sticky-header").removeClass("sticky");
      $('#back-top').fadeIn(500);
    } else {
      $("#sticky-header").addClass("sticky");
      $('#back-top').fadeIn(500);
    }
  });


  getPagination('#table-id');
  //getPagination('.table-class');
  //getPagination('table');

  /*					PAGINATION 
  - on change max rows select options fade out all rows gt option value mx = 5
  - append pagination list as per numbers of rows / max rows option (20row/5= 4pages )
  - each pagination li on click -> fade out all tr gt max rows * li num and (5*pagenum 2 = 10 rows)
  - fade out all tr lt max rows * li num - max rows ((5*pagenum 2 = 10) - 5)
  - fade in all tr between (maxRows*PageNum) and (maxRows*pageNum)- MaxRows 
  */


  function getPagination(table) {
    var lastPage = 1;

    $('#maxRows')
      .on('change', function (evt) {
        //$('.paginationprev').html('');						// reset pagination

        lastPage = 1;
        $('.pagination')
          .find('li')
          .slice(1, -1)
          .remove();
        var trnum = 0; // reset tr counter
        var maxRows = parseInt($(this).val()); // get Max Rows from select option

        if (maxRows == 5000) {
          $('.pagination').hide();
        } else {
          $('.pagination').show();
        }

        var totalRows = $(table + ' tbody tr').length; // numbers of rows
        $(table + ' tr:gt(0)').each(function () {
          // each TR in  table and not the header
          trnum++; // Start Counter
          if (trnum > maxRows) {
            // if tr number gt maxRows

            $(this).hide(); // fade it out
          }
          if (trnum <= maxRows) {
            $(this).show();
          } // else fade in Important in case if it ..
        }); //  was fade out to fade it in
        if (totalRows > maxRows) {
          // if tr total rows gt max rows option
          var pagenum = Math.ceil(totalRows / maxRows); // ceil total(rows/maxrows) to get ..
          //	numbers of pages
          for (var i = 1; i <= pagenum;) {
            // for each page append pagination li
            $('.pagination #prev')
              .before(
                '<li data-page="' +
                i +
                '">\
          <span>' +
                i++ +
                '<span class="sr-only">(current)</span></span>\
        </li>'
              )
              .show();
          } // end for i
        } // end if row count > max rows
        $('.pagination [data-page="1"]').addClass('active'); // add active class to the first li
        $('.pagination li').on('click', function (evt) {
          // on click each page
          evt.stopImmediatePropagation();
          evt.preventDefault();
          var pageNum = $(this).attr('data-page'); // get it's number

          var maxRows = parseInt($('#maxRows').val()); // get Max Rows from select option

          if (pageNum == 'prev') {
            if (lastPage == 1) {
              return;
            }
            pageNum = --lastPage;
          }
          if (pageNum == 'next') {
            if (lastPage == $('.pagination li').length - 2) {
              return;
            }
            pageNum = ++lastPage;
          }

          lastPage = pageNum;
          var trIndex = 0; // reset tr counter
          $('.pagination li').removeClass('active'); // remove active class from all li
          $('.pagination [data-page="' + lastPage + '"]').addClass('active'); // add active class to the clicked
          // $(this).addClass('active');					// add active class to the clicked
          limitPagging();
          $(table + ' tr:gt(0)').each(function () {
            // each tr in table not the header
            trIndex++; // tr index counter
            // if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
            if (
              trIndex > maxRows * pageNum ||
              trIndex <= maxRows * pageNum - maxRows
            ) {
              $(this).hide();
            } else {
              $(this).show();
            } //else fade in
          }); // end of for each tr in table
        }); // end of on click pagination list
        limitPagging();
      })
      .val(5)
      .change();

    // end of on select change

    // END OF PAGINATION
  }

  function limitPagging() {
    // alert($('.pagination li').length)

    if ($('.pagination li').length > 7) {
      if ($('.pagination li.active').attr('data-page') <= 3) {
        $('.pagination li:gt(5)').hide();
        $('.pagination li:lt(5)').show();
        $('.pagination [data-page="next"]').show();
      } if ($('.pagination li.active').attr('data-page') > 3) {
        $('.pagination li:gt(0)').hide();
        $('.pagination [data-page="next"]').show();
        for (let i = (parseInt($('.pagination li.active').attr('data-page')) - 2); i <= (parseInt($('.pagination li.active').attr('data-page')) + 2); i++) {
          $('.pagination [data-page="' + i + '"]').show();

        }

      }
    }
  }

  $(function () {
    // Just to append id number for each row
    $('table tr:eq(0)').prepend('<th> ID </th>');

    var id = 0;

    $('table tr:gt(0)').each(function () {
      id++;
      $(this).prepend('<td>' + id + '</td>');
    });
  });

  //  Developed By Yasser Mas
  // yasser.mas2@gmail.com





  $(document).ready(function () {

    $('#example').DataTable();

    // mobile_menu
    var menu = $('ul#navigation');
    if (menu.length) {
      menu.slicknav({
        prependTo: ".mobile_menu",
        closedSymbol: '+',
        openedSymbol: '-'
      });
    };
    // blog-menu
    // $('ul#blog-menu').slicknav({
    //   prependTo: ".blog_menu"
    // });

    // review-active
    $('.slider_active').owlCarousel({
      loop: true,
      margin: 0,
      items: 1,
      autoplay: true,
      navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
      nav: true,
      dots: false,
      autoplayHoverPause: true,
      autoplaySpeed: 800,
      animateOut: 'fadeOut',
      animateIn: 'fadeIn',
      responsive: {
        0: {
          items: 1,
          nav: false,
        },
        767: {
          items: 1
        },
        992: {
          items: 1
        },
        1200: {
          items: 1
        },
        1600: {
          items: 1
        }
      }
    });

    // review-active
    $('.testmonial_active').owlCarousel({
      loop: true,
      margin: 0,
      items: 1,
      autoplay: true,
      navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
      nav: false,
      dots: true,
      autoplayHoverPause: true,
      autoplaySpeed: 800,
      responsive: {
        0: {
          items: 1,
        },
        767: {
          items: 1,
        },
        992: {
          items: 1,
        },
        1200: {
          items: 1,
        },
        1500: {
          items: 1
        }
      }
    });

    $(function () {
      $("#slider-range").slider({
        range: true,
        min: 0,
        max: 600,
        values: [75, 300],
        slide: function (event, ui) {
          $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
        }
      });
      $("#amount").val("$" + $("#slider-range").slider("values", 0) +
        " - $" + $("#slider-range").slider("values", 1));
    });


    // for filter
    // init Isotope
    var $grid = $('.grid').isotope({
      itemSelector: '.grid-item',
      percentPosition: true,
      masonry: {
        // use outer width of grid-sizer for columnWidth
        columnWidth: 1
      }
    });

    // filter items on button click
    $('.portfolio-menu').on('click', 'button', function () {
      var filterValue = $(this).attr('data-filter');
      $grid.isotope({ filter: filterValue });
    });

    //for menu active class
    $('.portfolio-menu button').on('click', function (event) {
      $(this).siblings('.active').removeClass('active');
      $(this).addClass('active');
      event.preventDefault();
    });

    // wow js
    new WOW().init();

    // counter 
    $('.counter').counterUp({
      delay: 10,
      time: 10000
    });

    /* magnificPopup img view */
    $('.popup-image').magnificPopup({
      type: 'image',
      gallery: {
        enabled: true
      }
    });

    /* magnificPopup img view */
    $('.img-pop-up').magnificPopup({
      type: 'image',
      gallery: {
        enabled: true
      }
    });

    /* magnificPopup video view */
    $('.popup-video').magnificPopup({
      type: 'iframe'
    });


    // scrollIt for smoth scroll
    $.scrollIt({
      upKey: 38,             // key code to navigate to the next section
      downKey: 40,           // key code to navigate to the previous section
      easing: 'linear',      // the easing function for animation
      scrollTime: 600,       // how long (in ms) the animation takes
      activeClass: 'active', // class given to the active nav element
      onPageChange: null,    // function(pageIndex) that is called when page is changed
      topOffset: 0           // offste (in px) for fixed top navigation
    });

    // scrollup bottom to top
    $.scrollUp({
      scrollName: 'scrollUp', // Element ID
      topDistance: '4500', // Distance from top before showing element (px)
      topSpeed: 300, // Speed back to top (ms)
      animation: 'fade', // Fade, slide, none
      animationInSpeed: 200, // Animation in speed (ms)
      animationOutSpeed: 200, // Animation out speed (ms)
      scrollText: '<i class="fa fa-angle-double-up"></i>', // Text for element
      activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
    });


    // blog-page

    //brand-active
    $('.brand-active').owlCarousel({
      loop: true,
      margin: 30,
      items: 1,
      autoplay: true,
      nav: false,
      dots: false,
      autoplayHoverPause: true,
      autoplaySpeed: 800,
      responsive: {
        0: {
          items: 1,
          nav: false

        },
        767: {
          items: 4
        },
        992: {
          items: 7
        }
      }
    });

    // blog-dtails-page

    //project-active
    $('.project-active').owlCarousel({
      loop: true,
      margin: 30,
      items: 1,
      // autoplay:true,
      navText: ['<i class="Flaticon flaticon-left-arrow"></i>', '<i class="Flaticon flaticon-right-arrow"></i>'],
      nav: true,
      dots: false,
      // autoplayHoverPause: true,
      // autoplaySpeed: 800,
      responsive: {
        0: {
          items: 1,
          nav: false

        },
        767: {
          items: 1,
          nav: false
        },
        992: {
          items: 2,
          nav: false
        },
        1200: {
          items: 1,
        },
        1501: {
          items: 2,
        }
      }
    });

    if (document.getElementById('default-select')) {
      $('select').niceSelect();
    }

    //about-pro-active
    $('.details_active').owlCarousel({
      loop: true,
      margin: 0,
      items: 1,
      // autoplay:true,
      navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
      nav: true,
      dots: false,
      // autoplayHoverPause: true,
      // autoplaySpeed: 800,
      responsive: {
        0: {
          items: 1,
          nav: false

        },
        767: {
          items: 1,
          nav: false
        },
        992: {
          items: 1,
          nav: false
        },
        1200: {
          items: 1,
        }
      }
    });

  });

  // resitration_Form
  $(document).ready(function () {
    $('.popup-with-form').magnificPopup({
      type: 'inline',
      preloader: false,
      focus: '#name',

      // When elemened is focused, some mobile browsers in some cases zoom in
      // It looks not nice, so we disable it:
      callbacks: {
        beforeOpen: function () {
          if ($(window).width() < 700) {
            this.st.focus = false;
          } else {
            this.st.focus = '#name';
          }
        }
      }
    });
  });



  //------- Mailchimp js --------//  
  function mailChimp() {
    $('#mc_embed_signup').find('form').ajaxChimp();
  }
  mailChimp();



  // Search Toggle
  $("#search_input_box").hide();
  $("#search").on("click", function () {
    $("#search_input_box").slideToggle();
    $("#search_input").focus();
  });
  $("#close_search").on("click", function () {
    $('#search_input_box').slideUp(500);
  });
  // Search Toggle
  $("#search_input_box").hide();
  $("#search_1").on("click", function () {
    $("#search_input_box").slideToggle();
    $("#search_input").focus();
  });
  $(document).ready(function () {
    $('select').niceSelect();
  });

  // prise slider 








})(jQuery);	