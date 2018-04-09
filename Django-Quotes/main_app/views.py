# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from .models import Quote, Author
from .forms import QuoteForm, AuthorForm, SearchForm
from django.http import HttpResponseRedirect

from django.shortcuts import render

# Create your views here.
def index(request):
    authors = Author.objects.all()
    author_form = AuthorForm()
    quote_form = QuoteForm()
    search_quote_form = SearchForm()
    return render(request, 'index.html', {'authors': authors, 'author_form': author_form, 'quote_form': quote_form, 'search_quote_form': search_quote_form})

def quotes(request, author_id):
    author = Author.objects.get(id=author_id)
    quotes = author.quote_set.all()
    return render(request, 'quotes.html', {'author': author, 'quotes': quotes})

def post_author(request):
    form = AuthorForm(request.POST)
    if form.is_valid():
        form.save(commit = True)
    return HttpResponseRedirect('/')

def post_quote(request):
    form = QuoteForm(request.POST)
    if form.is_valid():
        form.save(commit = True)
    return HttpResponseRedirect('/')

def search_quote(request):
    form = SearchForm(request.POST)
    if form.is_valid():
        queryset = Quote.objects.all()
        text = form.cleaned_data['text']
        quotes = queryset.filter(quote_text__icontains = text)
    return render(request, 'search.html', {'quotes': quotes})
